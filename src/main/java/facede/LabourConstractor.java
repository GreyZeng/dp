package facede;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class LabourConstractor {
	private final Mason work1 = new Mason();
	private final BrickWorker work2 = new BrickWorker();
	private final BrickLayer work3 = new BrickLayer();

    

    public void buildHouse() {
        work1.mix();
        work2.carry();
        work3.neat();
    }
}
