# Midi2DataLibrary

This is a modificated version of the Midi2Texte application :https://github.com/Yxven/Midi2Text to work without GUI as a library an add the possibility to work with a java object instead of text File


 Here is an example file output: https://github.com/Brandonn-Etheve/Midi2DataLibrary/blob/master/example_output.txt .

This program includes JMusic1.6.4.jar which was originally found here: http://sourceforge.net/projects/jmusic/files/jMusic_Stable/ and is licensed
under GPLv2.

## Usage

File file = new File("c:/midiFile.mid");

MidiToData midi2Data = new MidiToData();

MidiContainer myMidiContainer =midi2Data.convert(file);

Note[] noteArray= midiContainer.getNoteArrays(73); //get notes for instruments 73 if exist
