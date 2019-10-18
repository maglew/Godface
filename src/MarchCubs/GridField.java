package MarchCubs;

import org.lwjgl.util.vector.Vector3f;

public class GridField
{
    Vector3f begin;
    Vector3f end;
    Gridcell grids[][][];
    float square;

    public GridField(Vector3f begin, Vector3f end)
    {
        this.begin = begin;
        this.end = end;
        square=Math.abs(end.x-begin.x*end.y-begin.y*end.z-begin.z);
        Gridcell grids[][][]=new Gridcell[(int)(end.x-begin.x)][(int)(end.y-begin.y) ][(int)(end.y-begin.y)];

    }

    void fit()
    {


    }
}
