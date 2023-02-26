import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Первая");

        route.add(new Station("Перовская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));
    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(actual,expected);
    }

    public void testGetRouteWithTwoConnections(){

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
