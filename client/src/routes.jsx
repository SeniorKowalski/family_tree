import About from './pages/about/About';
import Home from './pages/home/Home';

const routes = [
    {
        path: '',
        element: <Home />,
    },
    {
        path: 'about',
        element: <About />,
    },
];

export default routes;
