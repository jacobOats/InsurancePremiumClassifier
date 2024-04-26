<h1>Prerequisites</h1>
Before you can carry out the steps below, you need to have two things installed:
<ol>
  <li>Spring Tools 4 eclipse marketplace plugin (picture below)</li>
  <li>Node.js and npm (a package manager). If you download the latest node.js version, this should come with an instance of npm.</li>
</ol>

<br/><br/>
![spring tools](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/spring-tools.png)
<br/><br/>

<p>Node.js download: <a href="https://nodejs.org/en/download">https://nodejs.org/en/download</a></p>

<h1>Installation</h1>

<p>1. Clone the repository to your local machine</p>
git clone https://github.com/emu-computer-science/insurance-premium-classifier.git

<br/><br/>
![step 1](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/1.png)
<br/><br/>

<p>2. Open eclipse, click 'file' and then click on 'import...'</p>

<p>3. Click the 'Git' tab and select 'Projects from Git'</p>

<br/><br/>
![step 3](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/3.png)
<br/><br/>

<p>4. Select 'Existing local repository'</p>

<br/><br/>
![step 4](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/4.png)
<br/><br/>

<p>5. Next you will need to select the git repository. It likely won't be visible at this point and we'll need to add it. So, click 'Add..'</p>

<br/><br/>
![step 5](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/5.png)
<br/><br/>

<p>6. A new window like the one below should pop up. Since I've already tested this, the repository I want to import (insurance-premium-classifier) is already present. You'll likely need to browse your local file directory to import the repository (you only need to select the root folder of the repo). After you've selected it, click 'Add'.</p>

<br/><br/>
![step 6](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/6.png)
<br/><br/>

<p>7. You'll be brought to the original window. Now, select the insurance-premium-classifier repo and click 'Next'</p>

<br/><br/>
![step 7](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/7.png)
<br/><br/>

<p>8. This is probably the most important step. Import the project as a <b>general project</b></p>

<br/><br/>
![step 8](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/8.png)
<br/><br/>

<p>9. Click finish and you should now see the repository in your package explorer window. If you look at the folder icon next to the name, you'll notice that Eclipse does not label it as a Maven project or a Java project. If you try to run the application at this point, it'll likely fail.</p>

<br/><br/>
![step 9](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/9.png)
<br/><br/>

<p>10. To allow Eclipse to know this is a Maven and Java project, right click on 'insurance-premium-classifier' in the package explorer window, go to 'Configure' and then click on 'Convert to Maven Project'. After a few seconds, the project should have updated and the ICON should now have an 'M' and 'J' letting us know that we've successfully imported the project.</p>

<br/><br/>
![step 10](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/10.png)
<br/><br/>

<h1>Running the Project</h1>
<h2>Spring Boot</h2>
<p>You can start the backend portion of the application one of two ways:</p>
<ol>
  <li>Right click on the project, and go to 'Run as' and select 'Spring Boot App'</li>
  <li>Select 'insurance-premium-classifier' in the Boot Dashboard and press the far left icon (has the play button in it)</li>
</ol>

<br/><br/>
![dashboard](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/dashboard.png)
<br/><br/>

<h2>React</h2>
<p>1. Navigate to the frontend folder in your terminal</p>

<p>2. Run the following command</p>
npm install

<br/><br/>
![react step 1 & 2](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/react-1-2.png)
<br/><br/>

<p>3. Assuming you've already started the backend, now run the following command to launch our frontend development server</p>
npm run dev

<br/><br/>
![react step 3](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/react-3.png)
<br/><br/>

<p>4. A link will have popped up after running the command above. Now click on the link (you may need to hold 'ctrl'). Your default browser now should have called our local frontend development server (which runs on port 5173) and you should see the page below.</p>

<br/><br/>
![react step 4](https://github.com/seanpolid/insurance-premium-classifier-photos/blob/main/react-4.png)
<br/><br/>


