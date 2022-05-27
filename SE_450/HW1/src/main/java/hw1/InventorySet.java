package hw1;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

// TODO: complete the methods
/**
 * An Inventory implemented using a <code>HashMap&lt;Video,Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 *  Mutable Collection of Records
 *
 *   Every key and value in the map is non-<code>null</code>.
 *
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {

    /** <code>_data != null</code> */
    private final Map<VideoObj, Record> _data = new HashMap<VideoObj, Record>();

    /**
     * InventorSet Constructor
     */
    InventorySet()
    {

    }

    /**
     * @return  Return the number of Records.
     */
    public int size() {
        // TODO
        return _data.size();
    }

    /**
     * @param v Video object
     *  @return  Return a copy of the record for a given Video; if not present, return <code>null</code>.
     */
    public Record get(VideoObj v)
    {
        for (VideoObj _obj : _data.keySet())
        {
            if (_obj.equals(v))
            {
                return _data.get(_obj).copy();
            }
        }
        return null;
    }

    /**
     * @return Return a copy of the records as a collection.
     * Neither the underlying collection, nor the actual records are returned.
     */
    public Collection<Record> toCollection()
    {
        // Recall that an ArrayList is a Collection.
        Collection<Record> col_rec = new ArrayList<Record>();
        col_rec = _data.values();
        return col_rec;
    }

    /**
     * Add or remove copies of a video from the inventory.
     * If a video record is not already present (and change is
     * positive), a record is created.
     * If a record is already present, <code>numOwned</code> is
     * modified using <code>change</code>.
     * If <code>change</code> brings the number of copies to be zero,
     * the record is removed from the inventory.
     * @param video the video to be added.
     * @param change the number of copies to add (or remove if negative).
     * @throws IllegalArgumentException if video null, change is zero,
     *  if attempting to remove more copies than are owned, or if
     *  attempting to remove copies that are checked out.
     * changes the record for the video
     */
    public void addNumOwned(VideoObj video, int change)
    {
        if (video == null || change == 0)
        {
            throw new IllegalArgumentException("Video is null or change is zero");
        }
        if (_data.containsKey(video) == true)
        {
            if ((_data.get(video).numOwned + change) < _data.get(video).numOut)
            {
                throw new IllegalArgumentException("Attempting to remove copies that are checked out.");
            }
            if ((_data.get(video).numOwned + change) > _data.get(video).numOut)
            {
                if ((_data.get(video).numOwned + change) >= 1)
                {
                    _data.get(video).numOwned = _data.get(video).numOwned + change;
                }
            }
            else if ((_data.get(video).numOwned + change) <= 0 )
                {
                    _data.remove(video);
                }
        }
        else
        {
            if(change > 0 ) {
                Record _rec = new Record(video, change, 0, 0);
                _data.put(video, _rec);
            }
        }
    }

    /**
     * Check out a video.
     * @param video the video to be checked out.
     * @throws IllegalArgumentException if video has no record or numOut
     * equals numOwned.
     * postcondition - changes the record for the video
     */
    public void checkOut(VideoObj video)
    {
        if (_data.containsValue(_data.get(video)) == false || (_data.get(video).numOut) == (_data.get(video).numOwned))
        {
            throw new IllegalArgumentException("Video has no record or numOut equals numOwned.");
        }
        _data.get(video).numOut = _data.get(video).numOut + 1;
    }

    /**
     * Check in a video.
     * @param video the video to be checked in.
     * @throws IllegalArgumentException if video has no record or numOut
     * non-positive.
     * postcondition - changes the record for the video
     */
    public void checkIn(VideoObj video)
    {
        if (_data.containsValue(_data.get(video)) == false || (_data.get(video).numOut < 0))
        {
            throw new IllegalArgumentException("Video has no record or numOut non-positive.");
        }
        _data.get(video).numOut = _data.get(video).numOut - 1;
    }

    /**
     * Remove all records from the inventory.
     * postcondition - <code>size() == 0</code>
     */
    public void clear()
    {
        _data.clear();
    }

    /**
     * @return Return the contents of the inventory as a string.
     */
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Database:\n");
        for (Record r : _data.values()) {
            buffer.append("  ");
            buffer.append(r);
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
