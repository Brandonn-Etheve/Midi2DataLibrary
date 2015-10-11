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
package midi2Data;

import exception.InstrumentNotFoundException;
import java.util.Enumeration;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;

/**
 *This class try to store all music info into an object
 * @author brd
 * 
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
    
    public String getTitle()
    {
     return title;
        
    }
    public String getTimeSignature()
    {
        return timeSignature;
    }
    
    public double getBeatsPerMinute()
    {
        return beatsPerMinute;
    }
    public String getKeyQuality()
    {
        return keyQuality;
    }
    public int  getKeySignature()
    {
        return keySignature;
    }
    public double getLonguestRhytmValue()
    {
        return longuestRhytmValue;
    }
    public  Double getShortestRhytmValue()
    {
        return shortestRhytmValue;
    }
    public Enumeration  getPartList()
    {
        return partList;
    }  
    /**
     * This method return an Arrays of all note for the instruments given in parrameters
     * @param instrumentSearched
     * @return
     * @throws InstrumentNotFoundException 
     */
    public Note[] getNoteArrays(double instrumentSearched) throws InstrumentNotFoundException
    {
     
           
           Part part = null;
           Phrase phrase;
           Note[] noteArray = null;
           Enumeration phraseEnum = null;
           double instrument=-1;
           while(partList.hasMoreElements()&&instrument!=instrumentSearched)
           {
               
               part = (Part) partList.nextElement();
               phraseEnum= part.getPhraseList().elements();
               instrument=part.getInstrument();
               //System.out.println(instrument);
           }           
            if(instrument!=instrumentSearched)
            {
                throw new InstrumentNotFoundException();
            }
           while(phraseEnum.hasMoreElements())
           {
              phrase =(Phrase) phraseEnum.nextElement();
             noteArray= phrase.getNoteArray();
             
           } 
           
           return noteArray;
    }
}
