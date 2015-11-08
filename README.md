# digitalocean-routine

A script to create and delete droplets

## Usage

### Preparation

Replace placeholders in digitalocean-routine.sh.

```
token="DIGITAL OCEAN ACCESS TOKEN"
image_id="IMAGE ID"
ssh_key="SSH KEY FINGER PRINT"
```

### Commands

Create droplets

```
digitalocean-routine.sh create <the number of droplets to create>
```

Delete all the droplets.
```
digitalocean-routine.sh delete
```

## License

MIT
