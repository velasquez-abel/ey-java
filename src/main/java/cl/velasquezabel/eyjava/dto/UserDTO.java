private String name;

@Email(message = "Email should be valid")
private String email;

@Size(min = 1, message= "at least one phone number must be provided")
private List<PhoneNumber> phones;