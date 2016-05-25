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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   LinkedList<Part>  partList;
   
   private final static String[] INSTRUMENT_NAME =new String[]
   {
       "Acoustic Grand Piano", "Bright Acoustic Piano", "Electric Grand Piano", "Honky-tonk Piano",
       "Rhodes Piano", "Chorused Piano", "Harpsichord", "Clavinet", "Celesta", "Glockenspiel",
       "Music Box", "Vibraphone", "Marimba", "Xylophone", "Tubular Bells", "Dulcimer", "Hammond Organ",
       "Percussive Organ", "Rock Organ", "Church Organ", "Reed Organ", "Accordion", "Harmonica",
       "Tango Accordion", "Acoustic Nylon Guitar", "Acoustic Steel Guitar", "Electric Jazz Guitar", 
       "Electric Clean Guitar", "Electric Muted Guitar", "Overdriven Guitar", "Distortion Guitar", 
       "Guitar Harmonics", "Acoustic Bass", "Fingered Electric Bass", "Plucked Electric Bass", 
       "Fretless Bass", "Slap Bass 1", "Slap Bass 2", "Synth Bass 1", "Synth Bass 2", "Violin", 
       "Viola", "Cello", "Contrabass", "Tremolo Strings", "Pizzicato Strings", "Orchestral Harp", 
       "Timpani", "String Ensemble 1", "String Ensemble 2", "Synth Strings 1", "Synth Strings 2", 
       "Choir \"Aah\"", "Choir \"Ooh\"", "Synth Voice", "Orchestral Hit", "Trumpet", "Trombone", "Tuba",
       "Muted Trumpet", "French Horn", "Brass Section", "Synth Brass 1", "Synth Brass 2", "Soprano Sax", 
       "Alto Sax", "Tenor Sax", "Baritone Sax", "Oboe", "English Horn", "Bassoon", "Clarinet", "Piccolo",
       "Flute", "Recorder", "Pan Flute", "Bottle Blow", "Shakuhachi", "Whistle", "Ocarina", "Square Wave Lead",
       "Sawtooth Wave Lead", "Calliope Lead", "Chiff Lead", "Charang Lead", "Voice Lead", "Fifths Lead",
       "Bass Lead", "New Age Pad", "Warm Pad", "Polysynth Pad", "Choir Pad", "Bowed Pad", "Metallic Pad",
       "Halo Pad", "Sweep Pad", "Rain Effect", "Soundtrack Effect", "Crystal Effect", "Atmosphere Effect",
       "Brightness Effect", "Goblins Effect", "Echoes Effect", "Sci-Fi Effect", "Sitar", "Banjo", "Shamisen",
       "Koto", "Kalimba", "Bagpipe", "Fiddle", "Shanai", "Tinkle Bell", "Agogo", "Steel Drums", "Woodblock",
       "Taiko Drum", "Melodic Tom", "Synth Drum", "Reverse Cymbal", "Guitar Fret Noise", "Breath Noise",
       "Seashore", "Bird Tweet", "Telephone Ring", "Helicopter", "Applause"
   };
   
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
    public void setPartList(Enumeration enumPartList)
    {
        partList=new LinkedList<>();
        while(enumPartList.hasMoreElements())
        {
            partList.add((Part)enumPartList.nextElement());
        }
        //this.partList=partList;
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
    public List  getPartList()
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
     
         
           //Part part;
           Phrase phrase;
           List <Note> listNote =new ArrayList<>(); 
           Enumeration phraseEnum = null;
           double instrument=-1;
           
           //while(partList.h&& instrument!=instrumentSearched)
           for(Part part : partList)
           {
               phraseEnum= part.getPhraseList().elements();
               instrument=part.getInstrument();
               if(instrument==instrumentSearched)
               {
                   break;
               }
               //System.out.println(instrument);
           }           
            if(instrument!=instrumentSearched)
            {
                throw new InstrumentNotFoundException();
            }
            
           while(phraseEnum.hasMoreElements())
           {
              phrase =(Phrase) phraseEnum.nextElement();
            Note[] note= phrase.getNoteArray();
            listNote.addAll(Arrays.asList(note));
             
           } 
          Note[] noteArray=new Note[listNote.size()];
          int i=0;
           for(Note n : listNote)
           {
               noteArray[i]=n;
               i++;
           }
           return noteArray;
    }
    
    public static int getInstrumentNumber(String instrument) throws InstrumentNotFoundException
    {
        for(int i=0;i<127;i++)
        {
            if(INSTRUMENT_NAME[i].equalsIgnoreCase(instrument))
            {
                return i;
            }
        }
        throw new InstrumentNotFoundException();
    }
    
    public Map getInstrumentsFound()
    {
        Map<String, Integer>  instrumentsFound = new HashMap();
       
        for(int i=0;i<127;i++)
        {
            try {
                    Note noteArray[]=getNoteArrays(i);
                    if(noteArray.length>0)
                    {
                        
                        instrumentsFound.put(INSTRUMENT_NAME[i], noteArray.length);
                    }  
           
                 } catch (InstrumentNotFoundException ex) { }
        }
       
       
        return instrumentsFound;
    }
}
