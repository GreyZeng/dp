package facede;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class LabourConstractor {
	private Mason work1 = new Mason();
	private BrickWorker work2 = new BrickWorker();
	private BrickLayer work3 = new BrickLayer();

    

    public void buildHouse() {
        work1.mix();
        work2.carry();
        work3.neat();
    }
}
