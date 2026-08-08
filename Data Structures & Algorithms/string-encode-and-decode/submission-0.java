class Solution {

    public String encode(List<String> arr) {
        int n=arr.size();
        
        StringBuilder sb=new StringBuilder();
        
        for(String s:arr){
            sb.append(s.length()).append("/:").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        
        int i=0;
        int n=s.length();
        
        while(i<n){
            int j=i;
            
            while(s.charAt(j)!='/' && s.charAt(j+1)!=':'){
                j++;
            }
            
            int length=Integer.parseInt(s.substring(i, j));
            j+=2;
            
            result.add(s.substring(j, j+length));
            
            i=j+length;
        }
        
        return result;
    }
}
