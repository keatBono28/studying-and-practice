package applications.arraypractice;

public class PlusOne {
    public int[] plusOne(int[] digits){
        int len = digits.length;
        int[] dig = new int[digits.length];
        for (int i = 0; i < len ; i++) {
            int temp = Integer.parseInt(String.valueOf(digits[i]));
            dig[i+1] = temp;
        }
        if(digits[len - 1] != 9){
            dig[len - 1] += 1;
        } else{
            dig[len - 1] = 1;
            dig[len] = Integer.parseInt("0");
        }
        return dig;
    }
}
