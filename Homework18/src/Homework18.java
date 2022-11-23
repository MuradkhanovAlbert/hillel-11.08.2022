public class Homework18 {
    public static void main(String[] args){

        //Переменные для циклов
        int i;
        int j;

        //Тестовые данные для задания 1
        int[] age = {0,18,-1,19,-2,5,20};

        for ( i = 0; i < age.length; i++) {
           testAge(age[i]);
        }

        //Тестовые данные для задания 2
        //double a = 9;
        double a;
        double b = 8.2;

        for ( a = b; a <= 2*b; a++) {
            divisionMod(a,b);
        }

        //Тестовые данные для задания 3
        double[] salary = {3000,3999,4000,5000};
        double[] years = {0,1,3,4,5};

        for ( i = 0; i < years.length; i++ ) {
            for ( j = 0; j < salary.length; j++ ) {
                testExperienceYears(years[i], salary[j]);
            }
        }


    }
    /*Задание 1. Используя конструкцию if..else, напишите код, который получает число(возраст),
        если число меньше 0 - выводить неверный возрас, от 0 - 18 вы еще не совершеннолетний,
         18 и выше вы стали взрослым*/
    public static void testAge (int age) {
        String message;

        if (age < 0) {
            message="Неверный возраст";
        } else if (age < 18) {
            message="Вы еще несовершеннолетний";
        } else {
            message="Вы стали взрослым";
        }

        System.out.println(age+": "+message);
    }

    /*Задание 2. Даны переменные a и b. Проверьте, что a делится без остатка на b.
    Если это так - выведите “Делится” и результат деления, иначе выведите
     'Делится с остатком' и остаток от деления.*/
    public static void divisionMod(double a, double b) {
        double result;
        String message;
        double mod;

        mod = a % b;

        if (mod == 0) {
            result = a / b;
            message = a + ", " + b + ": " + "Делится. Результат: " + (int) result;
        } else {
            message = a + ", " + b + ": " + "Делится с остатком. Остаток: " + mod;
        }
        System.out.println(message);
    }

    /*Задание 3. Напишите код который будет осуществлять следующую логику.
    Если сотрудник проработал от 1 до 3х лет в компании, его зарплата увеличивается
    на 10%, если от 3x и выше то 20%. Если в результате увеличения полученная ЗП
     меньше 4000 тысяч, сотруднику прибавляется бонус в размере 1000 ,
      а если 4000 и больше плюс 500.*/
    public static void testExperienceYears(double years,double salary){
        double result;

        if (years >= 1 && years < 3) {
            result = salary * 1.1;
            //System.out.print(1.1+" ");
        } else if (years >= 3) {
            result = salary * 1.2;
            //System.out.print(1.2+" ");
        } else {
            result = salary;
        }

        if ( salary < 4000 ) {
            result=result+1000;
            // System.out.print(1000+" ");
        } else if ( salary >= 4000 ) {
            result=result+500;
            // System.out.print(500+" ");
        }
        System.out.println("Стаж "+years+", зарплата "+salary+": "+(int)result);
    }
}
