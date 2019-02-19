package org.nava.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nambi
 * 
 */
public class InvitationCommandApp
{

	/*
	 * When I want to send invitation to Stranger, Boss, Friend, Relative, I
	 * want it to be customized and delivered. I can update my InvitationManager
	 * how everyone has to be treated. Once I tell him, whom to be invited, he
	 * will know how the invitation to be sent.
	 */

	public static void main(String[] args)
	{
		InvitationCommandApp app = new InvitationCommandApp();
		app.sendInvitations();
	}

	public void sendInvitations()
	{

		List<InvitationCommand> commands = new ArrayList<InvitationCommand>();

		commands.add(new StrangerInvitation(new Stranger()));
		commands.add(new FriendInvitation(new Friend()));
		commands.add(new RelativeInvitation(new Relative()));
		commands.add(new BossInvitation(new Boss()));

		InvitationManager manager = new InvitationManager(commands);
		manager.sendInvitations();
	}

	/* The command interface visible to world; */
	interface InvitationCommand
	{
		void invite();
	}

	/* My Real world entities - objects - my guests */

	class Stranger
	{
		void sendEmail()
		{
			System.out.println("Inviting you stranger....dont come");
		}
	}

	class Boss
	{
		void visitAndInvite()
		{
			System.out.println("Respected Boss, Please grace my invitation");
		}

	}

	class Friend
	{
		void call()
		{
			System.out.println("Hi machi, va da ");
		}
	}

	class Relative
	{
		void sendSnailMail()
		{
			System.out.println("Dear Moms, Your presence is really required. ");
		}
	}

	/* Concrete command implementations */
	class StrangerInvitation implements InvitationCommand
	{
		Stranger stranger;

		StrangerInvitation(Stranger st)
		{
			this.stranger = st;
		}

		public void invite()
		{
			stranger.sendEmail();
		}
	}

	class BossInvitation implements InvitationCommand
	{
		Boss boss;

		BossInvitation(Boss st)
		{
			this.boss = st;
		}

		public void invite()
		{
			boss.visitAndInvite();
		}
	}

	class FriendInvitation implements InvitationCommand
	{
		Friend friend;

		FriendInvitation(Friend st)
		{
			this.friend = st;
		}

		public void invite()
		{
			friend.call();
		}
	}

	class RelativeInvitation implements InvitationCommand
	{
		Relative relative;

		RelativeInvitation(Relative st)
		{
			this.relative = st;
		}

		public void invite()
		{
			relative.sendSnailMail();
		}
	}

	/* Invitation Manager */
	class InvitationManager
	{
		List<InvitationCommandApp.InvitationCommand> commands;

		public InvitationManager(List<InvitationCommandApp.InvitationCommand> commands)
		{
			this.commands = commands;
		}

		void sendInvitations()
		{
			for (InvitationCommandApp.InvitationCommand command : commands)
			{
				command.invite();
			}
		}
	}

}
