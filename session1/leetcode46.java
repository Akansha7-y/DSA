// Permutations of a given string  leetcode 46

class main{
    static void permutations(char[] arr, int index){
        if(index==arr.length){
            System.out.println(new String(arr));
            return;        
    }
    for(int i=index; i<arr.length; i++){
        char temp= arr[index];
        arr[index]= arr[i];
        arr[i]= temp;

        permutations(arr,index+1);
        temp = arr[index];
        arr[index]= arr[i];
        arr[i] = temp;
    }
}
public static void main(String[] args){
    String s = "abc";
    permutations(s.toCharArray(), 0);
}
}