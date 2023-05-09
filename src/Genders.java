public enum Genders {
    MALE(ChooseGenderConstant.GENDER1),
    FEMALE(ChooseGenderConstant.GENDER2);

    private static final class ChooseGenderConstant{
        private static final String GENDER1 = "MALE";
        private static final String GENDER2 ="FEMALE";
        private ChooseGenderConstant(){}
    }

    private String value;

    private Genders(String value){
        this.value = value;
    }



}
