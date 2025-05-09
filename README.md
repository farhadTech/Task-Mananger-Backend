# Task-Mananger-Backend

The Problem I Faced: Infinite Recursion.
Before using @JsonBackReference, my entities had a bidirectional relationship:
    * `User` -> has many `Task`
    * `Task` -> has one `User`

When I returned a `User` or `Task` from an API (e.g., Swagger), Jackson (the JSON serializer in Spring Boot) tried to convert the object graph into JSON.

For example:
When serializing a`User`, it found:
    * A list of `Task`s -> each task had a `User` which again had a list of `Task`s -> etc.
* This causes infinite recursion, and the app crashes or hangs.

# What `@JsonManagedReference` and `@JsonBackReference` Do
These two annotations **help Jackson break that loop:**
    * `@JsonManagedReference`: This is the "forward" part of the reference (usually the parent).
    * `@JsonBackReference`: This is the "back" part of the reference (usually the child), and it will not be serialized.

So now, when Jackson serializes a `User`:
    * It includes the tasks (because of `@JsonManagedReference`)
    * But it does not include the user inside each task (because of `@JsonBackReference`)

That prevents the loop
Visual Example
Before
```json
{
  "id": 1,
  "username": "john",
  "task": [
    {
      "id": 1,
      "title": "Watch",
      "user": {
        "id": 1,
        "username": "john",
        "task": [
          ....
        ]
      }
    }
  ]
}
```

After adding annotations:
```json
{
  "id": 1,
  "username": "john",
  "task": [
    {
      "id": 1,
      "title": "Watch"
      // "user" is not serialized here anymore
    }
  ]
}
```