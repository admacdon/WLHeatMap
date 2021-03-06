package view.map;

import org.jdesktop.swingx.mapviewer.DefaultTileFactory;
import org.jdesktop.swingx.mapviewer.TileFactory;
import org.jdesktop.swingx.mapviewer.TileFactoryInfo;
import java.io.File;


public class CacheTileProvider extends TileFactoryInfo {
	private static final TileFactoryInfo INSTANCE = new CacheTileProvider();

	public static TileFactory getDefaultTileFactory(){
		return new DefaultTileFactory(INSTANCE);
	}
	
	private CacheTileProvider(){
		super(1, 16, 17, 256, true, true, getCurrentDirectory() + File.separator + 
				"assets" + File.separator + "map_cache", "x", "y", "z");
	}
	
	private static String getCurrentDirectory(){
		try {
			 return new File (".").getCanonicalPath();
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	public String getTileUrl(int x, int y, int zoom){
		try {
			return new File(baseURL + File.separator + (17 - zoom) + "_" + x + "_" + y + ".png").toURI().toString();
		} catch(Exception e){
			return "";
		}
	}
}
