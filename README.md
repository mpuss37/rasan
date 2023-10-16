# rasan-rasan
Kuncen is a password management program built with a simple, secure and transparent CLI-based designed with the aim of guiding users in password management so that their data remains safe. The name "Kuncen" was chosen to describe the program's role as administrator and keeper of user passwords, similar to the role of "Kuncen Royal" which guarded palaces on the island of Java in Indonesia.
rasan-rasan itself in Javanese means (likes to talk to people) rasan is a command line program that allows users to translate text quickly and simply

install it first :
pacman -S jdk-openjdk (based arch)
apt install jdk-openjdk (based debian)

https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe (based windows)

next step :
git clone https://github.com/mpuss37/rasan.git
cd rasan/
./install.sh
Congratulations, the program has been installed

Usage : 
rasan [OPTIONS]...[VALUES]
-f, --from 'source' [from] [to]    Specify source-lang (id for Indonesian) and target-lang (eng for English).
-t, --to   'source' [to]    Specifiy target-lang (id for Indonesian) will automatically detect the source-lang.
-l, --list   'acronym,name'    List target-lang (id for Indonesian) will loop format data : acronym,name.
-h, --help          Display usage,options and help.
Example :
rasan -f or --from hallo dunia id en, (source -> from -> to -> output)
rasan -t or --to hallo dunia en, (source -> to -> output)
