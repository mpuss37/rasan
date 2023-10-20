./gradlew jar
check_build=$(cd build)
current_path=$('pwd')
check_code_bash=$(cat $HOME/.bashrc | grep rasan)
  echo "berhasil build $full_path ✓"
  echo "hasil build $current_path build/libs ✓"
if [[ $check_code_bash != *rasan* ]]; then
echo "alias rasan='java -jar $current_path/build/libs/kuncen-1.0-SNAPSHOT.jar' " >> $HOME/.bashrc
  echo "add .bashrc (global) ✓"
else
  echo "cannot add .bashrc"
fi