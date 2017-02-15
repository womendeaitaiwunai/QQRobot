package example.lxl.myapplication.util.anima;

import android.graphics.Color;

import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.AnimationsSet;
import su.levenetc.android.textsurface.animations.Circle;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Loop;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Axis;
import su.levenetc.android.textsurface.contants.Direction;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;
import su.levenetc.android.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 * 电视播放弹幕效果  无限次
 */
public class ShapeRevealLoopSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder.create("000001111101100101011010101010").setColor(Color.WHITE).setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("101010101000010101011111101100").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
		Text textC = TextBuilder.create("111011111000000011101010101010").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();
		Text textD = TextBuilder.create("101010101010101100010101010101").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textC).build();
		Text textE = TextBuilder.create("010101010101010111100000110010").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textD).build();
		Text textF = TextBuilder.create("101011111111000000001101010111").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textE).build();
		Text textG = TextBuilder.create("110101010101010100000111111110").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textF).build();
		Text textH = TextBuilder.create("110000001010101010101010101000").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textG).build();
		Text textI = TextBuilder.create("111000000101001010101010101000").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textH).build();
		Text textJ = TextBuilder.create("010100101111100001010101010101").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textI).build();
		Text textK = TextBuilder.create("101010100011100010101000010101").setColor(Color.WHITE).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textJ).build();

		final int flash = 1500;

		textSurface.play(
				new Loop(
					Rotate3D.showFromCenter(textA, 500, Direction.CLOCK, Axis.X),
					new AnimationsSet(TYPE.PARALLEL,
							ShapeReveal.create(textA, flash, SideCut.hide(Side.LEFT), false),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(flash / 6), ShapeReveal.create(textA, flash, SideCut.show(Side.LEFT), false))
					),
					new AnimationsSet(TYPE.PARALLEL,
							Rotate3D.showFromSide(textB, 500, Pivot.TOP),
							new TransSurface(500, textB, Pivot.CENTER)
					),
					Delay.duration(500),
					new AnimationsSet(TYPE.PARALLEL,
							Slide.showFrom(Side.TOP, textC, 500),
							new TransSurface(1000, textC, Pivot.CENTER)
					),
					Delay.duration(500),
					new AnimationsSet(TYPE.PARALLEL,
							ShapeReveal.create(textD, 500, Circle.show(Side.CENTER, Direction.OUT), false),
							new TransSurface(1000, textD, Pivot.CENTER)
					),
					Delay.duration(500),

					new AnimationsSet(TYPE.PARALLEL,
							ShapeReveal.create(textE, 500, Circle.show(Side.CENTER, Direction.OUT), false),
							new TransSurface(1000, textE, Pivot.CENTER)
					),
					Delay.duration(500),

					new AnimationsSet(TYPE.PARALLEL,
							ShapeReveal.create(textF, 500, Circle.show(Side.CENTER, Direction.OUT), false),
							new TransSurface(1000, textF, Pivot.CENTER)
					),
					Delay.duration(500),
						new AnimationsSet(TYPE.PARALLEL,
								ShapeReveal.create(textG, 500, Circle.show(Side.CENTER, Direction.OUT), false),
								new TransSurface(3000, textG, Pivot.CENTER)
						),
						Delay.duration(500),
						new AnimationsSet(TYPE.PARALLEL,
								ShapeReveal.create(textH, 500, Circle.show(Side.CENTER, Direction.OUT), false),
								new TransSurface(1000, textH, Pivot.CENTER)
						),
						Delay.duration(500),
						new AnimationsSet(TYPE.PARALLEL,
								ShapeReveal.create(textI, 500, Circle.show(Side.CENTER, Direction.OUT), false),
								new TransSurface(1000, textI, Pivot.CENTER)
						),
						Delay.duration(500),
						new AnimationsSet(TYPE.PARALLEL,
								ShapeReveal.create(textJ, 500, Circle.show(Side.CENTER, Direction.OUT), false),
								new TransSurface(1000, textJ, Pivot.CENTER)
						),
						Delay.duration(500),
						new AnimationsSet(TYPE.PARALLEL,
								ShapeReveal.create(textK, 500, Circle.show(Side.CENTER, Direction.OUT), false),
								new TransSurface(1000, textK, Pivot.CENTER)
						),
						Delay.duration(500),

					new AnimationsSet(TYPE.PARALLEL,
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textK, 700), ShapeReveal.create(textK, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textJ, 700), ShapeReveal.create(textJ, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textI, 700), ShapeReveal.create(textI, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textH, 700), ShapeReveal.create(textH, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(2000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textG, 700), ShapeReveal.create(textG, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(2500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textF, 700), ShapeReveal.create(textF, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(3000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textE, 700), ShapeReveal.create(textE, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(3500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textD, 700), ShapeReveal.create(textD, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(4000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textC, 700), ShapeReveal.create(textC, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(4500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textB, 700), ShapeReveal.create(textB, 1000, SideCut.hide(Side.LEFT), true))),
							new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(5000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textA, 700), ShapeReveal.create(textA, 1000, SideCut.hide(Side.LEFT), true))),
							new TransSurface(5000, textA, Pivot.CENTER)
					)
				)
		);
	}
}
