full_path=$('pwd' /gradlew jar)
current_path=$('pwd')
check_code_bash=$(cat $HOME/.bashrc | grep rasan)
if [ $full_path ]; then
  echo "berhasil build $full_path"
  echo "hasil build $current_path build/libs"
else
  echo "gagal build."
fi
if [[ $check_code_bash != *rasan* ]]; then
echo "alias rasan='java -jar $current_path kuncen-1.0-SNAPSHOT.jar' " >> $HOME/.bashrc
  echo "berhasil add .bashrc"
else
  echo "sudah add .bashrc"
fi