package campingInfo;

import java.util.List;

public interface CampingDAO {

	public List<Camping> listCamping();

	public void updateCamping(Camping camping);

}
