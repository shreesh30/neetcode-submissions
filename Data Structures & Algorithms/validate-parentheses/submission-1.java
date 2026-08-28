class Solution {
    public boolean isValid(String s) {
        int n=s.length();

        Map<Character,Character> map=new HashMap<>();

        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char topChar=stack.pop();
                
                if(map.get(topChar)!=c){
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
