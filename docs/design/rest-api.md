# REST API

### USERS(CRUD)

| HTTP Method | URL Path           | Description |
|:-----------:|:-------------------|:-----------:|
|     GET     | /api/v1/users      |  모든 사용자 조회  |
|     GET     | /api/v1/users/{id} |   사용자 조회    |
|    POST     | /api/v1/users      |   사용자 등록    |
|     PUT     | /api/v1/users/{id} |   사용자 수정    |
|   DELETE    | /api/v1/users/{id} |   사용자 삭제    |

### CATEGORIES(CRUD)

| HTTP Method | URL Path                | Description |
|:-----------:|:------------------------|:-----------:|
|     GET     | /api/v1/categories      | 모든 카테고리 조회  |
|     GET     | /api/v1/categories/{id} |   카테고리 조회   |
|    POST     | /api/v1/categories      |   카테고리 등록   |
|     PUT     | /api/v1/categories/{id} |   카테고리 수정   |
|   DELETE    | /api/v1/categories/{id} |   카테고리 삭제   |

### POSTS(PAGING)

| HTTP Method | URL Path                                                            | Description |
|:-----------:|:--------------------------------------------------------------------|:-----------:|
|     GET     | /api/v1/posts/{category_id}?page={page}&limit={limit}&query={query} |   게시글 검색    |
|     GET     | /api/v1/posts/{id}                                                  |   게시글 조회    |
|    POST     | /api/v1/posts                                                       |   게시글 등록    |
|     PUT     | /api/v1/posts/{id}                                                  |   게시글 수정    |
|   DELETE    | /api/v1/posts/{id}                                                  |   게시글 삭제    |

### REPLIES(PAGING)

| HTTP Method | URL Path                              | Description |
|:-----------:|:--------------------------------------|:-----------:|
|     GET     | /api/v1/replies/{post_id}?page={page} |    댓글 조회    |
|    POST     | /api/v1/replies/{post_id}             |    댓글 등록    |
|     PUT     | /api/v1/replies/{id}                  |    댓글 수정    |
|   DELETE    | /api/v1/replies/{id}                  |    댓글 삭제    |