// print all subsets 78 

class solution{
    static void subset(String s, int index, String current){
        if(index == s.length()){
            System.out.println(current);
            return;
        }
        subset(s, index+1, current); // dont take character
        subset(s, index+1, current+s.charAt(index)); //take character
    }
    public static void main(String[] args){
            String s = "abcde";
            subset(s, 0,  " ");
    }
}