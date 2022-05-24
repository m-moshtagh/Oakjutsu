# Universal Unique Identifier

UUID also known as GUID is a 128-bit long value which is a practical practice for taking unique identifiers. The
Standard uses hex-digits.

`123e4567-e89b-12d3-a456-556642440000`

## UUID in Java

### java.util.UUID

We can instantiate this class using a constructor by providing two long values.

`UUID uuid = new UUID(long mostSignificant64Bits, long leastSignificant64Bits);`

We also have some static methods:

* A method to create version3 UUID. `nameUUIDFromBytes(byte[] bytes)`
* A method to create random UUID(version4) `UUID.randomUUID();`
* The third one creates by a string representation. `UUID.fromString(String uuidHexDigitString);`

### Generate using Hibernate

Hibernate also has various ways for generating UUID. We can use custom generators or also `GeneratedType.Auto` to
populate it automatically. But this is the case when UUID is the Primary Key.

#### Using GeneratedType.AUTO

```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Type(type = "uuid-char")
@Column(columnDefinition = "VARCHAR(255)", name = "id", updatable = false, nullable = false)
private UUID id;
```

Hibernate by default stores it as binary for storage efficiency. so if we don't mention `@Type` & `columnDefinition`
in that case.

#### Using custom generator

```java
@Id
@GeneratedValue(generator = "UUID")
@GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
)
@Column(name = "id", updatable = false, nullable = false)
private UUID id;
```

In order to use IP & Timestamp for UUID generation:

```java
@Id
@GeneratedValue(generator = "UUID")
@GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
        parameters = {
                @Parameter(
                        name = "uuid_gen_strategy_class",
                        value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                )
        }
)
@Column(name = "id", updatable = false, nullable = false)
private UUID id;
```

#### UUID as ordinary field

In some cases we may not use the UUID field as Primary key in that case we need to autogenerate it our self.

```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(columnDefinition = "VARCHAR(255)", name = "uuid", updatable = false, nullable = false, unique = true)
private UUID uuid;
private String firstname;
private String lastname;
private int age;

@PrePersist
public void populateUUID(){
        this.uuid=UUID.randomUUID();
        }
```
