/*
 * Copyright (C) 2015 brd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package midiToData;

import java.util.Enumeration;

/**
 *
 * @author brd
 */
public class MidiContainer {
    private String title,timeSignature,keyQuality;
   double beatsPerMinute,longuestRhytmValue,shortestRhytmValue;
   int keySignature;
   Enumeration  partList;
    public MidiContainer(){
        
    }
    
    public void setTitle(String title)
    {
     this.title=title;
        
    }
    public void setTimeSignature(String timeSignature)
    {
        this.timeSignature=timeSignature;
    }
    
    public void setBeatsPerMinute(double beatsPerMinute)
    {
        this.beatsPerMinute=beatsPerMinute;
    }
    public void setKeyQuality(String keyQuality)
    {
        this.keyQuality=keyQuality;
    }
    public void setKeySignature(int keySignature)
    {
        this.keySignature=keySignature;
    }
    public void setLonguestRhytmValue(double longuestRhytmValue)
    {
        this.longuestRhytmValue=longuestRhytmValue;
    }
    public void setShortestRhytmValue(Double shortestRhytmValue)
    {
        this.shortestRhytmValue=shortestRhytmValue;
    }
    public void setPartList(Enumeration partList)
    {
        this.partList=partList;
    }
    
}
