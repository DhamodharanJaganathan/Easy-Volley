<p align="center">
  <img src="https://raw.githubusercontent.com/DhamodharanJaganathan/Easy-Volley/master/Screenshots/android_banner.png">


# Easy-Volley-Android (Retry Policy Added)

Volley is an HTTP library that makes networking for Android apps easier and, most importantly, faster.

<p align="center">
  <img src="https://raw.githubusercontent.com/DhamodharanJaganathan/Easy-Volley/master/Screenshots/normal.png" width="256" >
 
</p>

## Demo

[<img src="https://raw.githubusercontent.com/DhamodharanJaganathan/Easy-Volley/master/Screenshots/google-play-badge.png" width="256" >](https://play.google.com/store/apps/details?id=com.dhamodharan.easyvolleyexample)

## Add as dependency
This library is not yet released in Maven Central, until then you can add as a library module or use JitPack.io add remote maven url

### Add this below line in root build.gradle

```groovy

    allprojects {
        repositories {
            maven {
                url "https://jitpack.io"
            }
        }
    }
```
    
then add a library dependency. **Remember** to check for latest release [here](https://github.com/DhamodharanJaganathan/Easy-Volley/releases) 
                             
```groovy
    dependencies {
        compile 'com.github.DhamodharanJaganathan:Easy-Volley:3.0.0'
    }
```

Add the INTERNET permission to your manifest file.

### You have to add this line:

```<uses-permission android:name="android.permission.INTERNET"/> ```

outside the application tag in your AndroidManifest.xml



## Example for GET method :

```java
 if (InternetConnectionChecker.getInstance(this).isOnline()) {

      HashMap<String, String> payload = new HashMap<>();  // Dummy payload

      String url = "http://httpbin.org/get?param1=hello";
      VolleyCall.getResponse(MainActivity.this, url, 0, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {
          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }
       @Override
        public void onError(JSONObject result) {
          // No Response from Server
        }
        @Override
        public void onVolleyError(String error) {
          // Error
        }
      });
    }  // No Internet Connection
```

## Example for POST method :    

```java
if (InternetConnectionChecker.getInstance(this).isOnline()) {

      // post data (ie: form data)
      HashMap<String, String> payload = new HashMap<>();
      payload.put("name", "Alif");
      payload.put("email", "http://itsalif.info");

      String url = "http://httpbin.org/post";
      VolleyCall.getResponse(MainActivity.this, url, 1, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {
          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(JSONObject result) {
          // No Response from Server
        }
        @Override
        public void onVolleyError(String error) {
          // Error
        }
      });
    }  // No Internet Connection
```

## Example for PUT method : 

```java
 if (InternetConnectionChecker.getInstance(this).isOnline()) {

      // post data (ie: form data)
      HashMap<String, String> payload = new HashMap<>();
      payload.put("name", "Alif");
      payload.put("email", "http://itsalif.info");

      String url = "http://httpbin.org/put";
      VolleyCall.getResponse(MainActivity.this, url, 2, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {
          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
          }
        @Override
        public void onError(JSONObject result) {
          // No Response from Server
        }
        @Override
        public void onVolleyError(String error) {
          // Error
        }
      });
    }  // No Internet Connection
```

## Example for DELETE method :

```java
if (InternetConnectionChecker.getInstance(this).isOnline()) {

      HashMap<String, String> payload = new HashMap<>();  // Dummy payload

      String url = "http://httpbin.org/delete";
      VolleyCall.getResponse(MainActivity.this, url, 3, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {
          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(JSONObject result) {
          // No Response from Server
        }
        @Override
        public void onVolleyError(String error) {
          // Error
        }
      });
    }  // No Internet Connection
```



