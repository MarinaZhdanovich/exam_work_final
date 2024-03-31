# Итоговая контрольная работа

## Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут домашние и вьючные животные.

## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный репозиторий (GitHub, GitLab или Bitbucket). Разработку вести в этом репозитории, использовать pull requests на изменения. Программа должна запускаться и работать, ошибок при выполнении программы быть не должно. Программа может использоваться в различных системах, поэтому необходимо разработать класс в виде конструктора.

## Задание

### Операционные системы и виртуализация (Linux)

1. **Использование команды cat в Linux**

   - Создать два текстовых файла: "Pets" (Домашние животные) и "Pack animals" (вьючные животные), используя команду cat в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.

     ```bash
     cat > Pets.txt
     Dog
     Cat
     Hamster
     
     cat > PackAnimals.txt
     Horse
     Camel
     Donkey
     ```

   - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.

     ```bash
     cat Pets.txt PackAnimals.txt > AllAnimals.txt
     cat AllAnimals.txt
     ```

   - Переименовать получившийся файл в "Human Friends".

     ```bash
     mv AllAnimals.txt "HumanFriends.txt"
     ```

2. **Работа с директориями в Linux**
   - Создать новую директорию и переместить туда файл "Human Friends".

     ```bash
     mkdir AllAnimals
     mv HumanFriends.txt AllAnimals/
     ```

3. **Работа с MySQL в Linux. Установить MySQL на вашу вычислительную машину**
   - Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.

     ```bash
      # Добавление репозитория MySQL
      https://dev.mysql.com/downloads/repo/apt/
      sudo apt install ./mysql-apt-config_0.8.29-1_all.deb
      
      # Установка MySQL
      sudo apt update
      sudo apt install mysql-server 
      sudo apt install mysql-client 
      sudo apt install mysql-workbench-community 
      sudo apt install mysql-shell
      
      # Вход в MySQL
      sudo mysql -u root
      mysql> CREATE USER admin@localhost IDENTIFIED BY '1234';
      mysql> GRANT ALL PRIVILEGES ON *.* TO admin@localhost WITH GRANT OPTION;
      ```

![MySQL](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/308405f1-6a58-4be7-9cc9-7df4ab689502)


4. **Управление deb-пакетами**
   - Установить и затем удалить deb-пакет, используя команду dpkg.

     ```bash
     # Установка пакета
     https://browser.yandex.by/
     sudo dpkg -i Yandex.deb
     sudo apt install jq  # yandex-browser-stable зависит от jq
     sudo apt --fix-broken install

     # Удаление пакета
     dpkg -l | grep yandex  # находим правильное имя для удаления пакета
     sudo dpkg --purge yandex-browser-stable  # удаление пакета вместе с конфигурационными файлами
     sudo dpkg -r yandex-browser-stable  # удаление пакета оставляя при этом его конфигурационные файлы
     ```

5. **История команд в терминале Ubuntu**
   - Сохранить и выложить историю ваших терминальных команд в Ubuntu.
      ![First](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/0b517288-b37c-4817-a7e1-829cf57c0fcf)
      
      ![Second](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/27d9ab9f-1c4e-4cbc-8836-4c2044e17d77)
      
      ![Third](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/45b8f473-6e35-4497-a787-608f32644839)
      
      ![Fourth](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/b6e666c3-cf69-4ee4-81d4-4f5734b70018)

6. **Диаграмма классов**

    - Создать диаграмму классов с родительским классом "Животные", и двумя подклассами: "Pets" и "Pack animals". В составы классов которых в случае Pets войдут классы: собаки, кошки, хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы). Каждый тип животных будет характеризоваться (например, имена, даты рождения, выполняемые команды и т.д.). Диаграмму можно нарисовать в любом редакторе, такими как Lucidchart, Draw.io, Microsoft Visio и других.
![Diagram](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/dd083270-5714-40ef-baf8-75cefb6257a1)


7. **Работа с MySQL**

    - После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" должна быть структурирована в соответствии с этой диаграммой. Например, можно создать таблицы, которые будут соответствовать классам "Pets" и "Pack animals", и в этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.).

8. Создать таблицы с иерархией из диаграммы в БД

9. Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения

    ```bash
    CREATE DATABASE Human_Friends;
    USE Human_friends;
    
    CREATE TABLE Animals
    (
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Animal_Groups VARCHAR(20)
    );
    
    INSERT INTO Animals (Animal_Groups)
    VALUES ('Pets'),
           ('Pack animals');
    
    CREATE TABLE Pets
    (
        Id INT AUTO_INCREMENT PRIMARY KEY,
        Type VARCHAR(20),
        Animal_Groups_id INT,
        FOREIGN KEY (Animal_Groups_id) REFERENCES Animals(Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Pets (Type, Animal_Groups_id)
    VALUES ('Dog', 1),
           ('Cat', 1),  
           ('Hamster', 1); 
    
    CREATE TABLE Pack_Animals
    (
        Id INT AUTO_INCREMENT PRIMARY KEY,
        Type VARCHAR(20),
        Animal_Groups_id INT,
        FOREIGN KEY (Animal_Groups_id) REFERENCES Animals(Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Pack_Animals (Type, Animal_Groups_id)
    VALUES ('Horse', 2),
           ('Camel', 2),  
           ('Donkey', 2); 
    
    
    CREATE TABLE Dog 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(50),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pets (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Dog (Name, BirthDate, Commands, Type_id)
    VALUES ('Cooper ', '2023-01-01', 'Sit, Stay, Fetch', 1),
           ('Buddy', '2023-01-02', 'Sit, Paw, Bark', 1),  
           ('Milo', '2023-01-03', 'Sit, Stay, Roll', 1);
           
    CREATE TABLE Cat 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(50),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pets (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Cat (Name, BirthDate, Commands, Type_id)
    VALUES ('Lucky', '2023-02-01', 'Sit, Pounce', 2),
           ('Jake', '2023-02-02', 'Sit, Pounce, Scratch', 2),  
           ('Mick', '2023-02-03', 'Meow, Scratch, Jump', 2);
           
           
    CREATE TABLE Hamster 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(50),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pets (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Hamster (Name, BirthDate, Commands, Type_id)
    VALUES ('Paddy', '2024-03-01', 'Roll, Hide', 3),
           ('Rocky', '2024-03-02', 'Roll, Spin', 3),  
           ('Amelli', '2024-03-03', 'Roll', 3);
    
    CREATE TABLE Horse 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(100),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pack_Animals (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Horse (Name, BirthDate, Commands, Type_id)
    VALUES ('Gwen', '2020-04-01', 'Trot, Canter, Gallop', 1),
           ('Tucker', '2020-04-02', 'Trot, Canter', 1),  
           ('Whisper', '2020-04-03', 'Trot, Jump, Gallop', 1);
           
           
    CREATE TABLE Camel 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(100),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pack_Animals (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Camel (Name, BirthDate, Commands, Type_id)
    VALUES ('Arielle', '2021-05-01', 'Walk, Carry Load', 2),
           ('Charlie', '2021-05-02', 'Walk, Sit', 2),  
           ('Sandy', '2021-05-03', 'Walk, Run', 2);
           
    CREATE TABLE Donkey 
    (       
        Id INT AUTO_INCREMENT PRIMARY KEY, 
        Name VARCHAR(20), 
        BirthDate DATE,
        Commands VARCHAR(100),
        Type_id INT,
        FOREIGN KEY (Type_id) REFERENCES Pack_Animals (Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
    );
    
    INSERT INTO Donkey (Name, BirthDate, Commands, Type_id)
    VALUES ('Bella', '2022-06-01', 'Walk, Carry Load, Bray', 3),
           ('Rufus', '2022-06-02', 'Walk, Bray, Kick', 3),  
           ('Peach', '2022-06-03', 'Walk, Carry Load', 3);
    ```

10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
    питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу. 
    ```bash
    SET SQL_SAFE_UPDATES = 0;
    DELETE FROM Camel;
    
    SELECT * FROM Horse
    UNION ALL
    SELECT * FROM Donkey;
     ```

11. Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице
    ```bash
    CREATE TABLE Young_Animals AS
    SELECT *,
    TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS Age_Months
    FROM (
    SELECT * FROM Dog
    UNION ALL
    SELECT * FROM Cat
    UNION ALL
    SELECT * FROM Hamster
    UNION ALL
    SELECT * FROM Horse
    UNION ALL
    SELECT * FROM Camel
    UNION ALL
    SELECT * FROM Donkey
    ) AS all_animals
    WHERE BirthDate BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
    
    SELECT * FROM Young_Animals;
     ```

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.


