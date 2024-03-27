# Итоговая контрольная работа

## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут домашние и Pack animals.

## Как сдавать проект

Для сдачи проекта необходимо создать отдельный общедоступный репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом репозитории, использовать пул реквесты на изменения. Программа должна запускаться и работать, ошибок при выполнении программы быть не должно. Программа, может использоваться в различных системах, поэтому необходимо разработать класс в виде конструктора

## Задание

### Операционные системы и виртуализация (Linux)

1. Использование команды cat в Linux
    - Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду cat в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
      `cat > Pets.txt 
      Dog
      Cat
      Hamster`
   
      `cat > PackAnimals.txt
      Horse
      Camel
      Donkey`

    - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
      `cat Pets.txt PackAnimals.txt > AllAnimals.txt`
      `cat AllAnimals.txt`

    - Переименовать получившийся файл в "Human Friends"(.
      `mv AllAnimals.txt "HumanFriends.txt"`

2. Работа с директориями в Linux
    - Создать новую директорию и переместить туда файл "Human Friends".
      `mkdir AllAnimals
      mv HumanFriends.txt AllAnimals/`

3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
    - Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
      `https://dev.mysql.com/downloads/repo/apt/
      sudo apt install ./mysql-apt-config_0.8.29-1_all.deb
      sudo apt install mysql-server
      sudo apt install mysql-client
      sudo apt install mysql-workbench-community
      sudo apt install mysql-shell`

      `sudo mysql -u root
      mysql> CREATE USER admin@localhost IDENTIFIED BY '1234';
      mysql> GRANT ALL ON *.* TO admin@localhost WITH GRANT OPTION;`

4. Управление deb-пакетами
    - Установить и затем удалить deb-пакет, используя команду dpkg.
      `https://browser.yandex.by/
      sudo dpkg -i Yandex.deb
      sudo apt install jq (yandex-browser-stable зависит от jq)
      sudo apt --fix-broken install`
         
      `dpkg -l | grep yandex (находим правильное имя для удаления пакета)
      sudo dpkg --purge yandex-browser-stable (удаление пакета вместе с конфигурационными файлами)
      sudo dpkg -r yandex-browser-stable (удаление пакета оставляя при этом его конфигурационные файлы)`

5. История команд в терминале Ubuntu
    - Сохранить и выложить историю ваших терминальных команд в Ubuntu.
      