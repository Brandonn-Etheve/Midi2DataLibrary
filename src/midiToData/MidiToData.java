//////////////////////////////////////////////
//                Midi2Data
//Midi2Data is a modification of the original Midi2Text
//
// Converts a MIDi file to a tab-delimeted
// text file.
//Converts a MIDi file to a java object
//useful for importing into
// a spreadsheet for statistical analysis.
//
// (c) 2005 Andrew R. Brown
// 
// This application is built using the jMusic
// library,m and hence this code is distibuted
// under the GPL license (see below).
//
//////////////////////////////////////////////

/*
This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or any
later version.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

*/
package midiToData;

import java.io.*;
import java.util.Enumeration;
import jm.music.data.*;
import jm.util.Read;


public class MidiToData {
 
    public void convertToTextFile(File midiFile,File outputTextFile)
{
    
   Score s= new Score();
        Read.midi(s,midiFile.toString());
        
       
        // open text file
        try {

            
            FileWriter textFile = new FileWriter(outputTextFile);
            String title = s.getTitle();
            textFile.write("#Title:\n");
            textFile.write(title + "\n");

            int timeSignatureNumerator = s.getNumerator();
            int timeSignatureDenominator = s.getDenominator();
            textFile.write("#Time Signature:\n");
            textFile.write(timeSignatureNumerator + "/" + timeSignatureDenominator + "\n");

            double bpm = s.getTempo();
            textFile.write("#Beats per Minute:\n");
            textFile.write(bpm + "\n");

            int keyQuality = s.getKeyQuality();
            textFile.write("#Key Quality:\n");
            if(keyQuality == 1) {
                textFile.write("Minor\n");
            } else {
                textFile.write("Major\n");
            }

            int keySignature = s.getKeySignature();
            textFile.write("#Key Signature. If it's positive, it's the number sharps otherwise the number flats:\n");
            textFile.write(keySignature + "\n");

            double longestRhythmValue = s.getLongestRhythmValue();
            textFile.write("#Longest Rhythm Value:\n");
            textFile.write(longestRhythmValue + "\n");

            double shortestRhythmValue = s.getShortestRhythmValue();
            textFile.write("#Shortest Rhythm Value:\n");
            textFile.write(shortestRhythmValue + "\n");

            textFile.write("#Start Time - Pitch - Duration - Dynamic - Pitch Name\n");
            // read note data and convert
            // get data values

            Enumeration enum1 = s.getPartList().elements();
            while (enum1.hasMoreElements()) {
                Part part = (Part) enum1.nextElement();
                textFile.write("#Part:\n");
                textFile.write(part.getTitle() + "\n");
                textFile.write("#Instrument:\n");
                textFile.write(Integer.toString(part.getInstrument()) + "\n");
                part.getTitle();
                Enumeration enum2 = part.getPhraseList().elements();
                while (enum2.hasMoreElements()) {
                    Phrase phrase = (Phrase) enum2.nextElement();
                    textFile.write("#New Phrase:\n");
                    double startTime = phrase.getStartTime();
                    Enumeration enum3 = phrase.getNoteList().elements();
                    while (enum3.hasMoreElements()) {
                        Note note = (Note) enum3.nextElement();
                        // start time
                        textFile.write(Double.toString(startTime) + "\t");
                        // pitch
                        textFile.write(Integer.toString(note.getPitch()) + "\t");
                        // duration
                        textFile.write(Double.toString(note.getDuration()) + "\t");
                        // velocity
                        textFile.write(Integer.toString(note.getDynamic()) + "\t");

                        //string representation of note
                        if(note.isRest()) {
                            textFile.write("Rest\n");
                        } else {
                            textFile.write(note.getNote() + "\n");
                        }
                        startTime += note.getDuration();
                    }
                }
            }
            textFile.close();
        } catch (IOException e) {
            System.err.println(e);
        }   
    
    
}
  

public MidiContainer convert(File midiFile)
{
    MidiContainer midiContainer= new MidiContainer();
   Score s= new Score();
        Read.midi(s,midiFile.toString());
        
       
        
        

            midiContainer.setTitle(s.getTitle()); 
            midiContainer.setTimeSignature(s.getNumerator()+"/"+s.getDenominator());
            midiContainer.setBeatsPerMinute(s.getTempo());

            int keyQuality = s.getKeyQuality();
            
            if(keyQuality == 1) {
                midiContainer.setKeyQuality("Minor");
            } else {
                midiContainer.setKeyQuality("Major");
            }
            midiContainer.setKeySignature(s.getKeySignature());
            midiContainer.setLonguestRhytmValue(s.getLongestRhythmValue());      
            midiContainer.setShortestRhytmValue(s.getShortestRhythmValue());
            midiContainer.setPartList(s.getPartList().elements());
            
return midiContainer;
           
}
    
    
}
