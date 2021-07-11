package applications.arraypractice;

import java.util.ArrayList;

public class PlusOne {

    public int[] plusOne(int[] digits){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(digits == null || digits.length == 0){
            int temp[] = {1};
            return temp;
        }
        int carry = 0;
        for (int i = digits.length -1; i >= 0 ; i--) {
            if(i == digits.length -1){
                carry = carry + digits[i] + 1;
            } else {
                carry += digits[i];
            }
            result.add(0, carry % 10);
            carry /= 10;
        }
        if(carry == 1){
            result.add(0,1);
        }
        int resultArray[] = new int[result.size()];
        for (int i = 0; i < result.size() ; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public int[] plusOneAdvanced(int[] digits){
        if(digits == null || digits.length == 0){
            int[] temp={1};
            return temp;
        }
        int carry=1;
        int i;
        for( i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                carry+=digits[i];
                digits[i]=carry;
                break;
            }
        }
        if(i<0){
            int[] result = new int[digits.length+1];
            result[0]=1;
            return result;
        }else
            return digits;
    }
}
