.. project information
.. |title| replace:: C4 Alpha
.. |slug| replace:: **cs1302-c4-alpha**
.. |semester| replace:: Fall 2022
.. |version| replace:: v2022.fa
.. |server| replace:: Odin

.. notices (need to manually update the urls)
.. |website| image:: https://img.shields.io/badge/cs1302uga.github.io-cs1302--c4--alpha-58becd
   :alt: cs1302uga.github.io/cs1302-c4-alpha
.. _website: https://cs1302uga.github.io/cs1302-c4-alpha/
.. |approved_notice| image:: https://img.shields.io/badge/Approved%20for-Fall%202022-green
   :alt: Approved for: |version|
.. |not_approved_notice| image:: https://img.shields.io/badge/In%20development-Not%20yet%20approved-red
   :alt: In development - Not yet approved

CSCI 1302 - |title| |version|
#############################

.. #|approved_notice|

|not_approved_notice| |website|_

This document contains the description for the |slug| project assigned to the
students in the |semester| CSCI 1302 classes at the University of Georgia.

**You are expected to read the entirety of this file before beginning your project.**

----

.. contents::

----

Project Preface
===============

Motivation
++++++++++

This first CSCI 1302 project for |semester| is designed to help you apply and extend your prerequisite Java
programming knowledge with new concepts from CSCI 1302 in a Unix development environment (i.e., |server|).

If you are competent with the learning outcomes for CSCI 1301 (i.e., the prerequisite course), then you
already have most of the Java programming knowledge required to complete this project; otherwise, this
assignment will help you identify the gaps in your prerequisite programming knowledge so that you can tackle
those gaps early in the semester. We also recommend completing the
`Tic-Tac-Toe Assignment <https://github.com/cs1302uga/cs1302-hw00>`_ before beginning this project.

This project will also require you to apply some of the new concepts covered in CSCI 1302, including
named packages, exceptions, file input/output (I/O), and Java development in a Unix environment. If you
have actively engaged with the CSCI 1302 course content offered so far this semester, then you should
be able to comfortably, but not necesarilly quickly, complete those aspects of the project by applying
what you have practiced and learned from your content engagement.

Finally, this project may require you to do things that you have never been given explicit directions
or instructions for -- this is just a part of software development. In such cases, you may need need
to do some research to help you plan your solution. That being said, we have intentionally written this
project description document so that it hopefully answers the majority of your questions -- if not, then
please do not hesitate to ask a question on the course Piazza or during office hours.

Academic Honesty
++++++++++++++++

All students at the University of Georgia explicitly agree to abide by the UGA student honor code
when they sign the application for their admission to the University. Additionally, all
students enrolled in a CSCI 1302 course section in |semester| are subject to the
Academic Honesty policy included in the |semester| CSCI 1302 course syllabus. Furthermore, anyone with
access to this project description document is expected to respect the copyright and licensing
terms provided or linked to at the bottom of this document.

With academic honesty in mind, we ask all |semester| CSCI 1302 students not to fork this repository
on GitHub. Doing so may make your copy of the project publicly visible, and that would violate
several of the policies described earlier. Instead of forking the repository, please follow the
instructions provided later in this document to acquire a copy of the project description and
starter code.

Course-Specific Learning Outcomes
+++++++++++++++++++++++++++++++++

If you work on and complete this project, then you will gain exposure and practice with
the following learning outcomes:

:LO1.a: Navigate and modify files, directories, and permissions in a multi-user Unix-like environment.
:LO1.b: (Partial) Execute, redirect, pipe, and manage programs/processes in a multi-user Unix-like environment.
:LO1.c: Create and modify text files and source code using a powerful terminal-based text editor such as Emacs or Vi.
:LO1.d: (Partial) Use shell commands to compile new and existing software solutions that are organized into multi-level packages and have external dependencies.
:LO2.b: (Partial) Define, throw, and propagate exceptions appropriately in a software solution.
:LO3.a: Create and update source code that adheres to established style guidelines.
:LO3.b: (Partial) Create class, interface, method, and inline documentation that satisfies a set of requirements.
:LO7.c: (Partial) Use common abstract data types and structures, including lists, queues, arrays, and stacks in solving typical problems.

Project Updates
+++++++++++++++

If your instructor updates the project's requirements or starter code before the project is due,
then this section will be updated to include a summary of those updates and, if needed,
instructions that describe how to update your working copy of the project with
the latest versions of any changed files.

Project Description
===================

[`cs1302.gameutil` API Documentation](https://cs1302uga.github.io/cs1302-c4-alpha/doc)

Introduction
++++++++++++

Getting Started
+++++++++++++++

Functional Requirements
+++++++++++++++++++++++

A *functional requirement* defines a specific behavior between program inputs and outputs,
and a collection of functional requirements describes how a program should function. If
your submission satisfies a functional requirement listed in this section, then the
requirement's point total is added to your submission grade.

cs1302.game.ConnectFour
-----------------------

:Object Phases:
   TODO: describe...

   .. image:: img/phases.svg

:``GamePhase.NEW``:
   When a ``ConnectFour`` object is created, the ``rows`` and ``cols`` instance variables
   are initialized to their supplied values, ...

   .. code-block:: java

      ConnectFour game = new ConnectFour(6, 7);

   .. image:: img/GamePhase.NEW.svg

:``GamePhase.READY``:
   .. code-block:: java

      game.setPlayerTokens(Token.RED, Token.BLUE);

   .. image:: img/GamePhase.READY.svg

:``GamePhase.PLAYABLE``:
   .. code-block:: java

      game.dropToken(0, 0); // player = 0, col = 0
      game.dropToken(1, 1); // player = 1, col = 1
      game.dropToken(0, 1); // player = 0, col = 1
      game.dropToken(1, 2); // player = 1, col = 2

   .. image:: img/GamePhase.PLAYABLE.svg?20220830

cs1302.game.ConnectFourDriver
-----------------------------

Non-Functional Requirements
+++++++++++++++++++++++++++

A *non-functional requirement* specifies criteria that can be used to judge your submission
independently from its function or behavior. If functional requirements describe what your
submission should *do*, then the non-functional requirements describe how your submission is
supposed to *be*. If your submission does not satisfy a non-functional requirement listed in
this section, then the requirement's point total is deducted from your submission grade.

:Structure (10/100):
   TODO.

:Environment (100):
   This project must be implemented in Java 17, and it must compile and run correctly on
   Odin using the specific version of Java 17 that is setup according to the instructions
   provided by your instructor. Graders are instructed not to modify source code when they
   attempt to compile a submission.

:Code Style (20):
   Every ``.java`` file that you include as part of your submission for this project must
   be in valid style as defined in the `CS1302 Code Style Guide <styleguide>`_. All of the
   individual code style guidelines listed in that document are part of this single
   non-functional requirement. This requirement is all or nothing.

   .. _styleguide: https://github.com/cs1302uga/cs1302-styleguide

Submission Instructions
+++++++++++++++++++++++

Project Checklist
=================

Appendices
==========

.. #############################################################################

.. copyright and license information
.. |copy| unicode:: U+000A9 .. COPYRIGHT SIGN
.. |copyright| replace:: Copyright |copy| Michael E. Cotterell, Bradley J. Barnes, and the University of Georgia.
.. standard footer
.. footer:: |copyright| See `LICENSE.rst <LICENSE.rst>`_ for license information.
            The content and opinions expressed on this Web page do not necessarily
            reflect the views of nor are they endorsed by the University of Georgia or the University
            System of Georgia.
