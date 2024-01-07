import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class StoreToys {
    private List<Toy> toys;
    public StoreToys(List<Toy> toys){
        this.toys=toys;
    }
    public String randomToy(){
        for(Toy item: toys){
        }
        Random random = new Random();
        double res = random.nextDouble();
        double sum = 0.0;
        for(Toy item: toys){
            sum += item.getWeightToy();
            if(res<sum){
                return item.getNameToy()+ ": номер " + item.getIdToy() + "; вес" + item.getWeightToy();

            }
        }
        return "0";

    }
    public void endRes(){
        try (FileWriter writer = new FileWriter("toys.txt")) {
            for(int i=1; i<=10; i++){
                if(randomToy() == "0"){
                    writer.write("Игрушки не найдены");
                }    
                else {
                    writer.write(randomToy());
                    writer.write("\n");

                }
                
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
