import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.util.DynamicCountyComparator;
import edu.ucsb.cs48.s20.demo.formbeans.SurveyResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SurveyControllerTest {

    @Test
    public void test_correct_sorting() {
        
        ArrayList<County> countyList = new ArrayList<>();
        County one = new County("One", 1, 1, 1, 1, 1, 3, 3);
        County two = new County("Two", 2, 2, 2, 2, 2, 2, 2);
        County three = new County("Three", 3, 3, 3, 3, 3, 1, 1);

        countyList.add(one);
        countyList.add(two);
        countyList.add(three);

        SurveyResult survey = new SurveyResult(2,2,2,2,2,-2,-2);

        DynamicCountyComparator s1 = new DynamicCountyComparator(survey);
        countyList.sort(s1);

        assertEquals(countyList.get(0), one);
        
    }

}