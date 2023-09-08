package challenge.components.createperson.form;

import net.serenitybdd.screenplay.targets.Target;

public class CreatePersonFields {
    public static Target FIRST_NAME_FIELD = Target.the("first name field").locatedBy("#first_name");
    public static Target LAST_NAME_FIELD = Target.the("last name field").locatedBy("#last_name");
    public static Target AGE_FIELD = Target.the("age field").locatedBy("#age");
    public static Target COUNTRY_FIELD = Target.the("search field").locatedBy("#country");

}
