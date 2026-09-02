public class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!this.map.containsKey(key)){
            this.map.put(key, new ArrayList<>());
        }

        this.map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result="";

        if(this.map.containsKey(key)){
            List<Pair> list=this.map.get(key);

            int low=0, high=list.size()-1;
            int mid;

            while(low<=high){
                mid=(low+high)/2;
                int timeVal=list.get(mid).timestamp;

                if(timeVal==timestamp){
                    return list.get(mid).value;
                }else if(timeVal<timestamp){
                    result=list.get(mid).value;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return result;
    }
}
