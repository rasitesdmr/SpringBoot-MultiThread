# 🎯 SpringBoot-MultiThread ?

## 📌 docker-compose.yaml

```yaml
docker-compose up --build -d
```

```yaml
docker-compose down -v
```

## 📌 Mockaroo

* Web Sayfası : https://www.mockaroo.com/

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th1.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th2.png">

## 📌 Controller

## ▶️(localhost:8080/thread/createUser)

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th3.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th4.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th5.png">

* Gelin nasıl çalışıyor ona bakalım. 
* Şimdi aynı anda 2 tane doysa yükledim ve bu dosyanın içindeki bilgileri database yazdırdım.
* Normalde java kodlarını satır satır çalıştırdığı için ilk baştaki dosyam yüklendikten sonra diğer dosyamın yüklenmesi gerekir.
* Biz burda birinci dosyamızı thread-1'e ikinci dosyamızı thread-2'ye vererek paralel olarak database yüklettik.
* Bunu database bakarak anlayabiliriz. Id numaraları sırayla gelmesi gerekirken aynı anda yüklendikleri için id ler arasında bir sıralama yok.

## ▶️(localhost:8080/thread/tenThread)

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th6.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th7.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th8.png">

<img src="https://github.com/rasitesdmr/SpringBoot-MultiThread/blob/master/image/th9.png">

* Gelin nasıl çalışıyor ona bakalım. 
* Bizim Thread havuzumuzda max 10 tane thread var.
* Bende bu 10 tane thread'e iş yüklüyorum.
* CompletableFuture.allOf yöntemiyle tüm CompletableFuture'ların tamamlanmasını beklemek istiyorum.
* Tamamlama bittikten sonra hangi yöntemin hangi thread'e kullandığını görebiliyoruz.

