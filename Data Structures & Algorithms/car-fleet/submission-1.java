class Solution {

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
}
