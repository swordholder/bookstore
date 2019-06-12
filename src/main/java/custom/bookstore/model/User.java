package custom.bookstore.model;

import custom.bookstore.validator.EmailConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotEmpty(message = "Email field should not be empty")
    @EmailConstraint
    private String email;

    @NotEmpty(message = "Password field should not be empty")
    private String password;

}
