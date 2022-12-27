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

<img src="th1">

<img src="th2">

## 📌 Controller

## ▶️(localhost:8080/thread/createUser)

<img src="th3">

<img src="th4">

<img src="th5">

* Gelin nasıl çalışıyor ona bakalım. 
* Şimdi aynı anda 2 tane doysa yükledim ve bu dosyanın içindeki bilgileri database yazdırdım.
* Normalde java kodlarını satır satır çalıştırdığı için ilk baştaki dosyam yüklendikten sonra diğer dosyamın yüklenmesi gerekir.
* Biz burda birinci dosyamızı thread-1'e ikinci dosyamızı thread-2'ye vererek paralel olarak database yüklettik.
* Bunu database bakarak anlayabiliriz. Id numaraları sırayla gelmesi gerekirken aynı anda yüklendikleri için id ler arasında bir sıralama yok.

## ▶️(localhost:8080/thread/tenThread)

<img src="th6">

<img src="th7">

<img src="th8">

<img src="th9">

* Gelin nasıl çalışıyor ona bakalım. 
* Bizim Thread havuzumuzda max 10 tane thread var.
* Bende bu 10 tane thread'e iş yüklüyorum.
* CompletableFuture.allOf yöntemiyle tüm CompletableFuture'ların tamamlanmasını beklemek istiyorum.
* Tamamlama bittikten sonra hangi yöntemin hangi thread'e kullandığını görebiliyoruz.

