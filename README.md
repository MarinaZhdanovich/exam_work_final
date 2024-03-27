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
      mysql> CREATE USER 'admin'@'localhost' IDENTIFIED BY '1234';
      mysql> GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;
      ```

![MySQL](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/308405f1-6a58-4be7-9cc9-7df4ab689502)


4. **Управление deb-пакетами**
   - Установить и затем удалить deb-пакет, используя команду dpkg.

     ```bash
     # Установка пакета
     wget https://browser.yandex.by/
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
      ![История1](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/0b517288-b37c-4817-a7e1-829cf57c0fcf)
      
      ![История2](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/27d9ab9f-1c4e-4cbc-8836-4c2044e17d77)
      
      ![iИстория3](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/45b8f473-6e35-4497-a787-608f32644839)
      
      ![История4](https://github.com/MarinaZhdanovich/exam_work_final/assets/117445657/b6e666c3-cf69-4ee4-81d4-4f5734b70018)





      
