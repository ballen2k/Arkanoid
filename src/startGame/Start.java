package startGame;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

public class Start {

	/**
	 * @param args
	 */
	private static Sequencer sm_sequencer = null;
	private static Synthesizer sm_synthesizer = null;

	public static void main(String[] args) {
		playMidi();
		view.Interface newGame = new view.Interface();
	}

	/**
	 * Borrowed code from
	 * http://www.jsresources.org/examples/SimpleMidiPlayer.java.html
	 *
	 * @author Matthias Pfisterer
	 * 
	 *         Copyright (c) 1999 - 2001 by Matthias Pfisterer All rights
	 *         reserved.
	 */
	public static void playMidi() {
		File mid = new File("img\\omg1.mid");
		Sequence sequence = null;

		try {
			sequence = MidiSystem.getSequence(mid);

		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			sm_sequencer = MidiSystem.getSequencer();

		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sm_sequencer.open();

		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sm_sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			sm_synthesizer = MidiSystem.getSynthesizer();
			sm_synthesizer.open();
			Receiver synthReceiver = sm_synthesizer.getReceiver();
			Transmitter seqTransmitter = sm_sequencer.getTransmitter();
			seqTransmitter.setReceiver(synthReceiver);

		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sm_sequencer.start();
	}

}
