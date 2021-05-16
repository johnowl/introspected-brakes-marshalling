## Micronaut 2.5.3

When I add `@Introspected` annotation to a data class that is used as a WebClient Response, i receive and error:

```
{
    "message": "Internal Server Error: Error decoding HTTP response body: Error decoding stream for type [class com.example.Response2]: Missing required creator property 'optionalValue' (index 3)\n at [Source: (byte[])\"{\n  \"args\": {}, \n  \"data\": \"\", \n  \"files\": {}, \n  \"form\": {}, \n  \"headers\": {\n    \"Accept\": \"application/json\", \n    \"Content-Length\": \"0\", \n    \"Host\": \"httpbin.org\", \n    \"Some-Header\": \"someValue\", \n    \"X-Amzn-Trace-Id\": \"Root=1-60a197e0-2bc162c60850883655b1ab73\"\n  }, \n  \"json\": null, \n  \"method\": \"POST\", \n  \"origin\": \"191.188.41.86\", \n  \"url\": \"https://httpbin.org/anything\"\n}\n\"; line: 17, column: 1]",
    "_links": {
        "self": {
            "href": "/it-does-not-work",
            "templated": false
        }
    }
}
```

The route `/it-works` is the annotation free version.
The route `/it-does-not-work` is the same as the previous one, but has the `@Introspected` annotation.