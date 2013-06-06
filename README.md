# Arquillian Transactional Samples

Some short examples using transaction management features in an Arquillian test.

Please feel free to have a look at [my blog] for the full tutorial.

## Starting the embedded GlassFish

Simply run the following command from the project directory:

```
mvn
```


## Calling the RESTful Webservice

**List all books**

```
curl -XGET http://localhost:8080/sample/ws/book/all
```

**Create new book**

```
curl -XPOST -H "Content-type: application/json" http://localhost:8080/sample/ws/book/all -d '{book:{title:"A book"}}'
```

----

** 2013 Micha Kops /hasCode.com**

   [my blog]:http://www.hascode.com
