🥘 Resep App
Resep App adalah aplikasi Android yang membantu pengguna mencari dan menyimpan berbagai resep makanan dengan mudah. Aplikasi ini dikembangkan menggunakan Android Studio Meerkat dan menyimpan data secara real-time menggunakan Firebase Realtime Database.

📸 Screenshot
<!-- Tambahkan gambar screenshot aplikasi Anda di sini. Contoh: -->

<!--  -->

🚀 Fitur Utama
🔍 Cari resep berdasarkan nama atau kategori

📤 Upload resep baru beserta deskripsi dan bahan-bahan

❤️ Simpan resep favorit

☁️ Data disimpan secara real-time dengan Firebase Realtime Database

🛠️ Teknologi yang Digunakan
Android Studio Meerkat

Bahasa: Kotlin (atau Java, sesuaikan dengan bahasa yang Anda gunakan di proyek ini)

Firebase Realtime Database

Firebase Storage (digunakan jika ada fitur upload gambar resep)

Material Design Components

📦 Cara Instalasi dan Menjalankan Aplikasi
Untuk mendapatkan salinan lokal proyek ini dan menjalankannya, ikuti langkah-langkah sederhana ini.

1. Clone Repositori
Buka terminal atau Command Prompt Anda, lalu jalankan perintah berikut:

git clone https://github.com/christiann234/ResepApp.git

2. Buka Proyek di Android Studio
Setelah proses kloning selesai, buka folder ResepApp yang baru saja diunduh menggunakan Android Studio Meerkat.

3. Konfigurasi Firebase
Aplikasi ini mengandalkan Firebase Realtime Database. Anda perlu mengonfigurasi proyek Firebase Anda sendiri:

Buat proyek baru di Firebase Console.

Tambahkan aplikasi Android ke proyek Firebase Anda. Pastikan nama paket (package name) cocok dengan yang ada di proyek Android Studio Anda (contoh: com.example.resepapp).

Unduh file google-services.json dan letakkan di direktori app/ dari proyek Android Studio Anda.

4. Build dan Jalankan
Setelah semua dependensi disinkronkan dan konfigurasi Firebase selesai, Anda dapat membangun (build) dan menjalankan aplikasi di emulator Android atau perangkat fisik.

📂 Struktur Proyek
Berikut adalah beberapa file dan direktori penting dalam struktur proyek Android ini:

app/src/main/java/com/example/resepapp/: Direktori utama yang berisi kode sumber Java/Kotlin aplikasi Anda (misalnya MainActivity.kt, model data, adapter, dll.).

app/src/main/res/layout/: Berisi semua file layout XML yang mendefinisikan antarmuka pengguna aplikasi.

app/google-services.json: File konfigurasi yang diperlukan untuk menghubungkan aplikasi Anda dengan Firebase.

build.gradle.kts (Project level): File konfigurasi Gradle untuk pengaturan build global proyek.

app/build.gradle.kts (Module level): File konfigurasi Gradle untuk dependensi dan pengaturan build spesifik modul aplikasi.

gradle.properties: Mengandung pengaturan Gradle di seluruh proyek, termasuk konfigurasi AndroidX dan gaya kode Kotlin.

.gitignore: Mengatur file dan folder yang diabaikan oleh Git agar tidak diunggah ke repositori.

🤝 Kontribusi
Kontribusi sangat dihargai! Jika Anda ingin berkontribusi pada proyek ini, silakan ikuti langkah-langkah berikut:

Fork repositori ini.

Buat branch baru untuk fitur Anda (git checkout -b feature/AmazingFeature).

Lakukan perubahan Anda dan commit (git commit -m 'Add some AmazingFeature').

Push ke branch Anda (git push origin feature/AmazingFeature).

Buka Pull Request.

📧 Kontak
Jika Anda memiliki pertanyaan atau ingin berdiskusi lebih lanjut tentang proyek ini, jangan ragu untuk menghubungi:

Christian Vieri - christianvieri20@gmail.com

Link Repositori Proyek: https://github.com/christiann234/ResepApp
