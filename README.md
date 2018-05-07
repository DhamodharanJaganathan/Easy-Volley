<p align="center">
  <img src="https://raw.githubusercontent.com/DhamodharanJaganathan/Easy-Volley/master/Screenshots/android_banner.png">


# Easy-Volley-Android (Retry Policy Added)

Volley is an HTTP library that makes networking for Android apps easier and, most importantly, faster.

<p align="center">
  <img src="https://raw.githubusercontent.com/DhamodharanJaganathan/Easy-Volley/master/Screenshots/screenshot-1520146598863.jpg" width="256" >
 
</p>

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
        compile 'com.github.DhamodharanJaganathan:Easy-Volley:2.0.0'
    }
```

## Example for GET method :

```grovy
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

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }
```

## Example for POST method :    

```grovy
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

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }
```

## Example for PUT method : 

```grovy
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

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }
```

## Example for DELETE method :

```grovy
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

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }
```

