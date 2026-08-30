class Solution {
    // Find the time it will take for each car to reach the target, and based on that
    // decide whether it belongs to a fleet or not
    /*
    class Car{
        private int position;
        private int speed;
        private double time;

        Car(int position, int speed, double time){
            this.position=position;
            this.speed=speed;
            this.time=time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars=new ArrayList<>();
        Stack<Double> stack=new Stack<>();

        for(int i=0;i<position.length;i++){
            cars.add(new Car(position[i],speed[i],(double)(target-position[i])/speed[i]));
        }

        cars.stream().sorted((c1,c2)->c2.position-c1.position).forEach(car->{
            if(stack.isEmpty()){
                stack.push(car.time);
            }else{
                if(stack.peek()<car.time){
                    stack.push(car.time);
                }
            }
        });

        return stack.size();
    }
    */


    /*
    * Optimized solution
    * Since we dont need the entire cars object, we can simply use the indices,
    * sort them based on the position and then use them to find the time and use that
    * time to find the number of fleets
    */
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        Stack<Double> stack = new Stack<>();

        for (int i : indices) {

            double time = (double) (target - position[i]) / speed[i];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
