# Easy-Volley-Android

Volley is an HTTP library that makes networking for Android apps easier and, most importantly, faster.

## Add as dependency
This library is not yet released in Maven Central, until then you can add as a library module or use JitPack.io

add remote maven url

add this blow line in root build.gradle

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
        compile 'com.github.DhamodharanJaganathan:Easy-Volley:1.0.0'
    }
```

```groovy
 // post data (ie: form data)
            HashMap<String, String> payload = new HashMap<>();
            payload.put("name", "Alif");
            payload.put("email", "http://itsalif.info");


            String url = "http://httpbin.org/post";
            VolleyCall.getResponse(MainActivity.this, url, "POST", payload, new VolleyCallback() {
                @Override
                public void onSuccessResponse(JSONObject response) {

                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }


                @Override
                public void verror(com.android.volley.VolleyError error) {

                    Toast.makeText(MainActivity.this, "Server not found", Toast.LENGTH_SHORT).show();

                }

            });
            
            ```
