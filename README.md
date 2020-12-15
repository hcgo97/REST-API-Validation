# REST-API-Validation


### com.example.demo.

### (1) entity.UsersEntity
  -> entity에 @Pattern annotaion으로 정규식 추가

### (2) controller.UsersController
  -> controller에 @Valid annotation 추가하여 유효성 검사

### (3) advice.MethodErrorResponse
  -> MethodArgumentNotValidException에서 작동하는 ErrorResponse 추가하여 GlobalExceptionHandler와 매핑

### (4) advice.GlobalExceptionHandler
  -> MethodArgumentNotValidException 에서 bindingResult값 추가하여 entity @Pattern에서 정의했던 defaultMessage 출력되게 함
