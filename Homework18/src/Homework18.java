public class Homework18 {
    public static void main(String[] args){
        testAge();
        DivisionMod();
        TestExperienceYears();

    }
    public static void testAge () {
        int[] age={0,18,-1,19,-2,5,20};
        int i;
        String message;

        for (i=0;i<age.length;i++) {
            if (age[i] < 0) {
                message=age[i]+": Неверный возраст";
            } else if (age[i] >= 0 && age[i] < 18) {
                message=age[i]+": Вы еще несовершеннолетний";
            } else {
                message=age[i]+": Вы стали взрослым";
            }
            System.out.println(message);
        }
    }

    public static void DivisionMod(){
        //int a=9;
        int a;
        int b=8;
        int mod;
        double result;
        String message;

        for (a=b;a<=2*b;a++) {
            mod = a % b;
            if (mod == 0) {
                result = a / b;
                message = a + ", " + b + ": " + "Делится. Результат: " + (int) result;
            } else {
                message = a + ", " + b + ": " + "Делится с остатком. Остаток: " + mod;
            }
            System.out.println(message);
        }
    }

    public static void TestExperienceYears(){
        int[] salary={3000,3999,4000,5000};
        int[] years={0,1,3,4,5};
        int i;
        int j;
        double result;

        for (i=0;i<years.length;i++) {
            for (j=0;j<salary.length;j++) {
                if (years[i] >= 1 && years[i] < 3) {
                    result = salary[j] * 1.1;
                    //System.out.print(1.1+" ");
                } else if (years[i] >= 3) {
                    result = salary[j] * 1.2;
                    //System.out.print(1.2+" ");
                } else {
                    result = salary[j];
                }

                if (salary[j]<4000) {
                    result=result+1000;
                   // System.out.print(1000+" ");
                } else if (salary[j]>=4000) {
                    result=result+500;
                   // System.out.print(500+" ");
                }
                System.out.println("Стаж "+years[i]+", зарплата "+salary[j]+": "+(int)result);
            }

            }

        }

}
