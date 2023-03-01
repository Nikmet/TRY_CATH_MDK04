public class Main {
    public static void main(String[] args) {
        System.out.println(Main.check("fhb_6786", "fhb_6786","fhb_6786"));
    }
    public static boolean check(String login, String password, String confirmPassword){
        String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
        String[] letters = {"a","b","c","d","e","f","g","h","i","k","l","m","n","o","p","q","s","t","u","v","w","x","y","z"};

        int a = 0;
        int len = login.length();
        int b = 0;
        int len1 = password.length();
        try {
            for (String letters1 : letters) {
                if (login.contains(letters1)) a += 1;
                if (password.contains(letters1)) b += 1;
            }
            if (a == 0) throw new WrongLoginException();
            if (b == 0) throw new WrongPasswordException();
            a = 0;
            b = 0;
            for (String numbers1 : numbers) {
                if (login.contains(numbers1)) a += 1;
                if (password.contains(numbers1)) b += 1;
            }
            if ((a == 0) | (!login.contains("_")) | (len > 20)) throw new WrongLoginException("Неправильый логин");
            if ((b == 0) | (!password.contains("_")) | (len1 > 20) | (!password.equals(confirmPassword))) throw new WrongPasswordException("Неправильный пароль");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    }
